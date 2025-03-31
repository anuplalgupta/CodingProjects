"use strict";

import _ from "lodash";
import { faker } from "@faker-js/faker";
import P from "bluebird";

/*
  We don't like OOP - in fact - we despise it!

  However, most real world implementations of something like a log source
  will be in OO form - therefore - we simulate that interaction here.
*/
export class LogSource {
  constructor({ onLogEntryHandler }) {
    this.drained = false;
    this.last = {
      date: new Date(Date.now() - 1000 * 60 * 60 * 24 * _.random(40, 60)),
      msg: faker.company.catchPhrase(),
    };
    this.onLogEntryHandler = onLogEntryHandler;
  }

  getNextPseudoRandomEntry() {
    const newEntry = {
      date: new Date(
        this.last.date.getTime() +
          1000 * 60 * 60 * _.random(10) +
          _.random(1000 * 60),
      ),
      msg: faker.company.catchPhrase(),
    };

    return newEntry;
  }

  pop() {
    return this.#popEntry();
  }

  popAsync() {
    return P.delay(_.random(8)).then(() => {
      const maybeLatestEntryReference = this.#popEntry(true);
      return maybeLatestEntryReference;
    });
  }

  #popEntry(isAsync = false) {
    const latestEntryReference = this.getNextPseudoRandomEntry();
    this.last = latestEntryReference;
    if (latestEntryReference.date > new Date()) {
      this.drained = true;
    } else {
      this.onLogEntryHandler(isAsync);
    }
    return this.drained ? false : latestEntryReference;
  }
};
