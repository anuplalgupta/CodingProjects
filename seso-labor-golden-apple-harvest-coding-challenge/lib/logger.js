"use strict";

const LogLevel = {
  ERROR: "error",
  WARN: "warn",
  INFO: "info",
  DEBUG: "debug",
};
const levels = [
  LogLevel.ERROR,
  LogLevel.WARN,
  LogLevel.INFO,
  LogLevel.DEBUG,
];
const currentLogLevel = process.env.LOG_LEVEL || LogLevel.DEBUG;

// Helper function to check if a message should be logged based on the current log level
const shouldLog = (level) => {
  return levels.indexOf(level) <= levels.indexOf(currentLogLevel);
};

// Logger functions
export const logger = {
  error: (message, ...optionalParams) => {
    if (shouldLog(LogLevel.ERROR)) {
      console.error(message, ...optionalParams);
    }
  },
  warn: (message, ...optionalParams) => {
    if (shouldLog(LogLevel.WARN)) {
      console.warn(message, ...optionalParams);
    }
  },
  info: (message, ...optionalParams) => {
    if (shouldLog(LogLevel.INFO)) {
      console.info(message, ...optionalParams);
    }
  },
  debug: (message, ...optionalParams) => {
    if (shouldLog(LogLevel.DEBUG)) {
      console.debug(message, ...optionalParams);
    }
  },
};
