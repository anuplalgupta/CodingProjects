import flask
from flask import request, jsonify


app = flask.Flask(__name__)
app.config["DEBUG"] = True




@app.route('/', methods=['GET'])
def home():
    return "<h1>Value Calculation service</h1><p>Use this to calculate the fair value of companies listed in NSE</p>"

@app.route('/value', methods=['GET'])
def value():
    val ='0'
    if 'syml' in request.args:
        syml = request.args['syml']
        if syml=='INFY':
            val ='556.18'
        if syml=='RIL':
            val = '1591.48'

    return jsonify( val+ ' INR')

app.run()


