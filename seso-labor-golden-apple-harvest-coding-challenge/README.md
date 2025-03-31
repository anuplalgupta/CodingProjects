<table>
  <tr>
    <td>
      <img src="./assets/seso-eng-logo.png" alt="Seso Engineering Logo" width="75" height="75" />
    </td>
    <td style="vertical-align: bottom;">
      <h1 style="" >Seso Engineering | Challenge: Log Sorting</h1>
    </td>
  </tr>
</table>

## Instructions

We have a number of [**log sources**](./lib/log-source.js). Each log source contains N log entries. Each entry is a javascript object with a timestamp and message. We don't know the number of log entries each source contains - however - we do know that the entries within each source are sorted 🕒 **chronologically** 🕒.

### The Objectives:

1. **_Drain all of the log sources_** for both the synchronous and asynchronous solutions.
   - [Synchronous](./lib/log-source.js#L37)
   - [Asynchronous](./lib/log-source.js#L51)
1. Print all of the entries, across all of the sources, in chronological order.
   - We don't need to store the log entries, just print them to stdout.
1. Do this _efficiently_. There are time and space complexities afoot!

We expect candidates to spend 1-3 hours on this exercise.

**We want to see you flex your CS muscles!!! Use the appropriate data structures to satisfy the time and space complexities inherent to the problem!!!**

## Pointers & Callouts

- We don't know how many logs each source contains. A source could contain millions of entries and be exabytes in size! In other words, reading the entirety of a log source into memory won't work well.
- Log sources could contain logs from last year, from yesterday, even from 100 years ago. We won't know the timeframe of a log source until we start looking.
- Consider what would happen when asked to merge 1 million log sources. Where might bottlenecks arise?

There are two parts of the challenge which you'll see when diving into things. You can get started by running `npm start`.

## Submitting

Push your solution to the `main` branch of this repo. Once you’re done, add the **"Ready to Review"** label to your [pull request](../../pull/1) that was automatically created for you.

If - for whatever reason - you cannot push to this GitHub repo, it is also acceptable to 'zip' the directory and provide your submission as an email attachment.
