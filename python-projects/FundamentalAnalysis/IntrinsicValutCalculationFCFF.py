#!/usr/bin/env python

from urllib.request import urlopen
import json


# def get_jsonparsed_data(url):
#     """
#     Receive the content of ``url``, parse it as JSON and return the object.

#     Parameters
#     ----------
#     url : str

#     Returns
#     -------
#     dict
#     """
#     response = urlopen(url)
#     data = response.read().decode("utf-8")
#     return json.loads(data)

# url = ("https://financialmodelingprep.com/api/v3/discounted-cash-flow/AAPL?apikey=demo")
# print(get_jsonparsed_data(url))

from bs4 import BeautifulSoup as bs
import pandas as pd
import requests
import pandas_datareader as dr
import datetime

def get_required_dataframes (ticker):
    #create cashflow dataframe
    url_cf = "https://financial-statements.p.rapidapi.com/api/v1/resources/cash-flow"
    querystring = {"ticker":ticker}

    fs_api_host = "financial-statements.p.rapidapi.com"
    rapid_api_key = "3706acacb3msh46c55e4830d7093p19c8eejsnbb320118c331"
    headers_fs = {
        'x-rapidapi-host': fs_api_host,
        'x-rapidapi-key': rapid_api_key
        }
    cash_flow_response = requests.request("GET", url_cf, headers=headers_fs, params=querystring)
    cash_flow_df = pd.DataFrame.from_dict(cash_flow_response.json())
    cash_flow_df = cash_flow_df.drop('ttm', axis = 1)

    url_is = "https://financial-statements.p.rapidapi.com/api/v1/resources/income-statement"
    income_statement_response = requests.request("GET", url_is, headers=headers_fs, params=querystring)
    # Create Income Statement DataFrame
    income_statement_df = pd.DataFrame.from_dict(income_statement_response.json())
    income_statement_df = income_statement_df.drop('ttm', axis = 1)
    income_statement_df


    url_bs = "https://financial-statements.p.rapidapi.com/api/v1/resources/balance-sheet"
    balance_sheet_response = requests.request("GET", url_bs, headers=headers_fs, params=querystring)
    # Create Balance Sheet DataFrame
    balance_sheet_df = pd.DataFrame.from_dict(balance_sheet_response.json())
    balance_sheet_df

    url_ks = "https://stock-analysis.p.rapidapi.com/api/v1/resources/key-stats"
    sa_api_host = "stock-analysis.p.rapidapi.com"
    headers_sa = {
        'x-rapidapi-key': rapid_api_key,
        'x-rapidapi-host': sa_api_host,
        'useQueryString': 'true'
        }
    key_stats_response = requests.request("GET", url_ks, headers=headers_sa, params=querystring)
    key_stats_response.json()
    key_stats_df = pd.DataFrame.from_dict(key_stats_response.json())
    key_stats_df = key_stats_df.transpose()
    key_stats_df
    return cash_flow_df, income_statement_df, balance_sheet_df, key_stats_df



def calculate_intrisic_value( company_ticker):

    cash_flow_df, income_statement_df, balance_sheet_df, key_stats_df = get_required_dataframes(company_ticker)
    # FCFF Calculation using Cash Flow Statement and Income Statement
    free_cash_flow_firm = (cash_flow_df.loc['Free Cash Flow'].astype(int) + (income_statement_df.loc['Interest Expense'].astype(int) * (1 - income_statement_df.loc['Tax Provision'].astype(int) / income_statement_df.loc['Pretax Income'].astype(int)))).astype(int)
    # Change Series to a Pandas Dataframe
    free_cash_flow_firm_df = free_cash_flow_firm.to_frame().transpose()
    free_cash_flow_firm_df

    # CAGR of FCFF
    latest_free_cash_flow_firm = float(free_cash_flow_firm_df.iloc[0,len(free_cash_flow_firm_df.columns)-1])
    earliest_free_cash_flow_firm = float(free_cash_flow_firm_df.iloc[0,1])
    free_cash_flow_firm_CAGR = (latest_free_cash_flow_firm/earliest_free_cash_flow_firm)**(float(1/(len(free_cash_flow_firm_df.columns)-2)))-1
    free_cash_flow_firm_CAGR


    # Constant Expected Growth Rate
    long_term_growth = free_cash_flow_firm_CAGR / 2
    long_term_growth
    # Forecasted FCFF
    forecast_free_cash_flow_firm_df = pd.DataFrame(columns=['Year ' + str(i) for i in range(1,7)])
    free_cash_flow_firm_forecast_lst = []
    for i in range(1,7):
        if i != 6:
            free_cash_flow_firm_forecast = latest_free_cash_flow_firm*(1+free_cash_flow_firm_CAGR)**i
        else:
            free_cash_flow_firm_forecast = latest_free_cash_flow_firm*(1+free_cash_flow_firm_CAGR)**(i-1)*(1+long_term_growth)
        free_cash_flow_firm_forecast_lst.append(int(free_cash_flow_firm_forecast))
    forecast_free_cash_flow_firm_df.loc[0] = free_cash_flow_firm_forecast_lst
    forecast_free_cash_flow_firm_df


    # Risk-free Rate
    timespan = 100
    current_date = datetime.date.today()
    past_date = current_date-datetime.timedelta(days=timespan)
    risk_free_rate_df = dr.DataReader('^TNX', 'yahoo', past_date, current_date)
    risk_free_rate = (risk_free_rate_df.iloc[len(risk_free_rate_df)-1,5])/100
    risk_free_rate


    # Stock's Beta
    equity_beta = float(key_stats_df.loc[r'Beta (5Y monthly)'])
    equity_beta
    # Market Risk Premium
    market_risk_premium = 0.0523
    # Required Return on Equity
    equity_return = risk_free_rate + (equity_beta*market_risk_premium)
    equity_return
    # Interest Expense
    interest_expense = income_statement_df.loc['Interest Expense']
    interest_expense_df = interest_expense.to_frame().transpose()
    interest_expense_str = interest_expense_df.values[0][-1:]
    interest_expense_int = int(interest_expense_str)
    # Total Debt
    total_debt = balance_sheet_df.loc['Total Debt']
    total_debt_df = total_debt.to_frame().transpose()
    total_debt_str = total_debt_df.values[0][-1:]
    total_debt_int = int(total_debt_str)
    # Required Return on Debt
    debt_return = interest_expense_int / total_debt_int
    debt_return
    # Effective Tax Rate
    effective_tax_rate = income_statement_df.loc['Tax Provision'].astype(int) / income_statement_df.loc['Pretax Income'].astype(int)
    avg_effective_tax_rate = sum(effective_tax_rate) / len(effective_tax_rate)
    avg_effective_tax_rate
    # Market Value of Equity
    market_cap_str = key_stats_df.loc[r'Market cap (intra-day) '][0]
    market_cap_lst = market_cap_str.split('.')
    if market_cap_str[len(market_cap_str)-1] == 'T':
        market_cap_length = len(market_cap_lst[1])-1
        market_cap_lst[1] = market_cap_lst[1].replace('T',(9-market_cap_length)*'0')
        market_cap_int = int(''.join(market_cap_lst))
    if market_cap_str[len(market_cap_str)-1] == 'B':
        market_cap_length = len(market_cap_lst[1])-1
        market_cap_lst[1] = market_cap_lst[1].replace('B',(6-market_cap_length)*'0')
        market_cap_int = int(''.join(market_cap_lst))
    market_cap_int

    # Market Value of Debt
    net_debt = balance_sheet_df.loc['Net Debt']
    net_debt_df = net_debt.to_frame().transpose()
    net_debt_str = net_debt_df.values[0][-1:]
    net_debt_int = int(net_debt_str)
    net_debt_int
    # Company Value
    company_value = market_cap_int + net_debt_int
    company_value
    WACC = ((market_cap_int/company_value) * equity_return)             + ((net_debt_int/company_value) * (debt_return * (1-avg_effective_tax_rate)))
    WACC
    # Equity Value Calculation
    discounted_FCFF_lst = []
    for year in range(0,5):
        discounted_FCFF = forecast_free_cash_flow_firm_df.iloc[0,year]/(1+WACC)**(year+1)
        discounted_FCFF_lst.append(int(discounted_FCFF))
    terminal_value = forecast_free_cash_flow_firm_df.iloc[0,5]/(WACC-long_term_growth)
    PV_terminal_value = int(terminal_value/(1+WACC)**5)
    enterprise_value = sum(discounted_FCFF_lst)+PV_terminal_value
    equity_value = enterprise_value-net_debt_int
    equity_value
    # Total Shares Outstanding
    shares_outstanding_str = key_stats_df.loc[r'Shares outstanding '][0]
    shares_outstanding_lst = shares_outstanding_str.split('.')
    if shares_outstanding_str[len(shares_outstanding_str)-1] == 'T':
        shares_outstanding_length = len(shares_outstanding_lst[1])-1
        shares_outstanding_lst[1] = shares_outstanding_lst[1].replace('T',(9-shares_outstanding_length)*'0')
        shares_outstanding_int = int(''.join(shares_outstanding_lst))
    if shares_outstanding_str[len(shares_outstanding_str)-1] == 'B':
        shares_outstanding_length = len(shares_outstanding_lst[1])-1
        shares_outstanding_lst[1] = shares_outstanding_lst[1].replace('B',(6-shares_outstanding_length)*'0')
        shares_outstanding_int = int(''.join(shares_outstanding_lst))
    shares_outstanding_int
    # Two-stage FCFF Valuation instrinsic Stock Price Estimate
    intrinsic_price = equity_value / shares_outstanding_int
    intrinsic_price = '${:,.2f}'.format(intrinsic_price)

    # Actual Stock Price
    actual_stock_price = market_cap_int / shares_outstanding_int
    actual_stock_price = '${:,.2f}'.format(actual_stock_price)
    return intrinsic_price, actual_stock_price

# intrinsic_price, actual_stock_price =  calculate_intrisic_value("MSFT")
# print("Intrinsic Stock Price = %s"%(intrinsic_price))
# print("Actual Stock Price = %s"%(actual_stock_price))

#TODO cleanup code


import yfinance as yf

def fcf_last_four_years(symbol:str):
    url_cf = "https://financial-statements.p.rapidapi.com/api/v1/resources/cash-flow"
    querystring = {"ticker":symbol}

    fs_api_host = "financial-statements.p.rapidapi.com"
    rapid_api_key = "3706acacb3msh46c55e4830d7093p19c8eejsnbb320118c331"
    headers_fs = {
        'x-rapidapi-host': fs_api_host,
        'x-rapidapi-key': rapid_api_key
        }
    cash_flow_response = requests.request("GET", url_cf, headers=headers_fs, params=querystring)
    cash_flow_df = pd.DataFrame.from_dict(cash_flow_response.json())
    cash_flow_df = cash_flow_df.drop('ttm', axis = 1)
    # print(cash_flow_df)
    # print(cash_flow_df.loc['Free Cash Flow',:].values.tolist())
    fcf = cash_flow_df.loc['Free Cash Flow',:].values.tolist()
    return fcf


def Intrinsic_value_fcf_DCF_model( symbol : str):
    tkr = yf.Ticker(symbol)
    os_shares = tkr.info['sharesOutstanding']

    # Constants and assumptions
    perp_rate = 0.02 #2%
    req_rate = 0.07 #7%
    cf_growth_rate = 0.03

    yrs = [1,2,3,4]
    fcf =  list(map(int, fcf_last_four_years(symbol))) #[50803000, 60000000,50000000,70000000] #TODO get it throught API

    future_fcf = []
    discountFactor = []
    discounted_future_fcf = []

    terminal_value = fcf[-1] * (1+perp_rate)/(req_rate-perp_rate)
    print("terminal_value is "+str(terminal_value))

    for y in yrs :
        cf = fcf[-1] *  (1+cf_growth_rate)**y
        future_fcf.append(cf)
        discountFactor.append((1+req_rate)**y)

    print("discount factor is "+ str(discountFactor))
    print("future fcf is "+ str(future_fcf))

    for i in range(0,len(yrs)):
        discounted_future_fcf.append(future_fcf[i]/discountFactor[i])

    print("discounted future fcf is "+str(discounted_future_fcf))

    discounted_terminal_value = terminal_value/(1+req_rate)**4
    discounted_future_fcf.append(discounted_terminal_value)

    todaysIntValCompany = sum(discounted_future_fcf)
    fair_val = todaysIntValCompany*1000/os_shares

    print("fair value of "+symbol+"is :"+str(fair_val))

Intrinsic_value_fcf_DCF_model('aapl')
