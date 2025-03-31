"use strict";

import _ from "lodash";

import { logger } from "./logger.js";

export class Printer {
  constructor({ type, onDone }) {
    this.last = new Date(0);
    this.logsPrinted = 0;
    this.type = type;
    this.onDone = onDone;
  }

  print(log) {
    if (!_.isDate(log.date)) {
      throw new Error(log.date + " is not a date");
    }
    if (log.date >= this.last) {
      logger.debug(log.date, log.msg);
    } else {
      throw new Error(log.date + " is not greater than " + this.last);
    }
    this.last = log.date;
    this.logsPrinted++;
    if (this.logsPrinted === 1) {
      this.startTime = new Date();
    }
  }

  done(logSources, message) {
    var timeTaken = (new Date() - this.startTime) / 1000;
    const allLogSourcesDrained = logSources.every((logSource) => logSource.drained);
    const { logEntryCount, popUsageCount } = this.onDone();
    const logsPrinted = this.logsPrinted;
    const logsPerSecond = logsPrinted / timeTaken;
    const usedCorrectPopMethod = popUsageCount ? popUsageCount === logEntryCount : false;
    const memoryUsage = process.memoryUsage();

    const result = {
      allLogSourcesDrained,
      logCount: logEntryCount,
      logsPerSecond,
      logsPrinted,
      message,
      usedCorrectPopMethod,
      timeTaken,
      memoryUsage,
    };

    logger.info(JSON.stringify(result));
  }
};
