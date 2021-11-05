import yfinance as yf

# Get the data for the stock AAPL

from_date = '2016-01-01'
to_date = '2019-08-01'
ticker = 'AAPL'
data = yf.download( ticker, from_date, to_date )