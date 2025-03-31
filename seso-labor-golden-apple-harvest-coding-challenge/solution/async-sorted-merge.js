"use strict";

export const asyncSortedMerge = async (logSources, printer) => {
  const heap = new MinHeap();

  // Initialize the heap with the first log entry from each source
  await Promise.all(logSources.map(async (source) => {
    const entry = await source.popAsync();
    if (entry) {
      heap.insert({ source, entry });
    }
  }));

  while (heap.size() > 0) {
    const { source, entry } = heap.extractMin();
    printer.print(entry);

    const nextEntry = await source.popAsync();
    if (nextEntry && nextEntry.date) {
      heap.insert({ source, entry:nextEntry });
    } else {
      source.drained = true;
    }
  }

  // Ensure all sources are drained
  let allDrained = false;
  while (!allDrained) {
    allDrained = true;
    await Promise.all(logSources.map(async (source) => {
      if (!source.drained) {
        const nextEntry = await source.popAsync();
        if (nextEntry && nextEntry.date) {
          heap.insert({ source, nextEntry });
          allDrained = false;
        }
      }
    }));

    while (heap.size() > 0) {
      const { source, entry } = heap.extractMin();
      printer.print(entry);

      const nextEntry = await source.popAsync();
      if (nextEntry && nextEntry.date) {
        heap.insert({ source, nextEntry });
      } else {
        source.drained = true;
      }
    }
  }

  printer.done(logSources);
};

// MinHeap implementation
class MinHeap {
  constructor() {
    this.heap = [];
  }

  insert(item) {
    if (item && item.entry && item.entry.date) {
      this.heap.push(item);
      this.bubbleUp(this.heap.length - 1);
    }
  }

  extractMin() {
    if (this.heap.length === 1) {
      return this.heap.pop();
    }

    const min = this.heap[0];
    this.heap[0] = this.heap.pop();
    this.bubbleDown(0);
    return min;
  }

  bubbleUp(index) {
    while (index > 0) {
      const parentIndex = Math.floor((index - 1) / 2);
      if (this.heap[index].entry.date >= this.heap[parentIndex].entry.date) {
        break;
      }
      [this.heap[index], this.heap[parentIndex]] = [this.heap[parentIndex], this.heap[index]];
      index = parentIndex;
    }
  }

  bubbleDown(index) {
    const length = this.heap.length;
    while (true) {
      const leftChildIndex = 2 * index + 1;
      const rightChildIndex = 2 * index + 2;
      let smallest = index;

      if (leftChildIndex < length && this.heap[leftChildIndex].entry.date < this.heap[smallest].entry.date) {
        smallest = leftChildIndex;
      }

      if (rightChildIndex < length && this.heap[rightChildIndex].entry.date < this.heap[smallest].entry.date) {
        smallest = rightChildIndex;
      }

      if (smallest === index) {
        break;
      }

      [this.heap[index], this.heap[smallest]] = [this.heap[smallest], this.heap[index]];
      index = smallest;
    }
  }

  size() {
    return this.heap.length;
  }
}