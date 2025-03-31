"use strict";

import { LogSource } from "./lib/log-source.js";
import { Printer } from "./lib/printer.js";

import { syncSortedMerge } from "./solution/sync-sorted-merge.js";
import { asyncSortedMerge } from "./solution/async-sorted-merge.js";

const RUN_ONLY = process.env.RUN_ONLY || "all";
// Adjust this input to see how your solutions perform under various loads.
const LOG_SOURCE_COUNT = Number(process.env.LOG_SOURCE_COUNT || 100);

function runSyncSolution() {
  let logEntryCount = 0;
  let popUsageCount = 0;
  /**
   * Challenge Number 1!
   *
   * Assume that a LogSource only has one method: pop() which will return a LogEntry.
   *
   * A LogEntry is simply an object of the form:
   * {
   * 		date: Date,
   * 		msg: String,
   * }
   *
   * All LogEntries from a given LogSource are guaranteed to be popped in chronological order.
   * Eventually a LogSource will end and return boolean false.
   *
   * Your job is simple: print the sorted merge of all LogEntries across `n` LogSources.
   *
   * Call `printer.print(logEntry)` to print each entry of the merged output as they are ready.
   * This function will ensure that what you print is in fact in chronological order.
   * Call 'printer.done()' at the end to get a few stats on your solution!
   */
  const syncLogSources = [];
  for (let i = 0; i < LOG_SOURCE_COUNT; i++) {
    syncLogSources.push(new LogSource({ onLogEntryHandler: (isAsync) => {
      logEntryCount++;
      if (!isAsync) popUsageCount++;
    }}));
  }

  syncSortedMerge(syncLogSources, new Printer({ type: "sync", onDone: () => ({ logEntryCount, popUsageCount })}));
}

async function runAsyncSolution() {
  let logEntryCount = 0;
  let popUsageCount = 0;
  /**
   * Challenge Number 2!
   *
   * Similar to Challenge Number 1, except now you should assume that a LogSource
   * has only one method: popAsync() which returns a promise that resolves with a LogEntry,
   * or boolean false once the LogSource has ended.
   *
   * Your job is simple: print the sorted merge of all LogEntries across `n` LogSources.
   *
   * Call `printer.print(logEntry)` to print each entry of the merged output as they are ready.
   * This function will ensure that what you print is in fact in chronological order.
   * Call 'printer.done()' at the end to get a few stats on your solution!
   */
  const asyncLogSources = [];
  for (let i = 0; i < LOG_SOURCE_COUNT; i++) {
    asyncLogSources.push(new LogSource({ onLogEntryHandler: (isAsync) => {
      logEntryCount++;
      if (isAsync) popUsageCount++;
    }}));
  }
  await asyncSortedMerge(asyncLogSources, new Printer({ type: "async", onDone: () => ({ logEntryCount, popUsageCount })}));
}

const gogogo = async () => {
  switch (RUN_ONLY) {
    case "sync":
      runSyncSolution();
      break;
    case "async":
      await runAsyncSolution();
      break;
    case "all":
    default:
      // Run both solutions
      runSyncSolution();
      await runAsyncSolution();
  }
};

await gogogo();
