from IntrinsicValutCalculationFCFF import Intrinsic_value_fcf_DCF_model
from flask import Flask
from flask import request
import traceback


app = Flask('IntrinsicValueCalculator')

@app.route("/calculate-intrinsic-val")
def calculate_intrisic_value():
    tkr = request.args.get('ticker')
    try:
        return Intrinsic_value_fcf_DCF_model(tkr)
    except:
        traceback.print_exc()
        return 'Please check if ticker:{} is valid'.format(tkr)

app.run()
