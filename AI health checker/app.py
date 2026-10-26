from flask import Flask, render_template, request

from symptom_checker import predict_disease
from report_generator import generate_report
from visualizations import create_chart

app = Flask(__name__)

@app.route('/')

def home():
    welcome = "Welcome to AI Health Symptom Checker"
    return render_template("index.html")

@app.route('/predict', methods=["POST"])

def predict():

    fever = int(request.form["fever"])
    cough = int(request.form["cough"])
    headache = int(request.form["headache"])
    fatigue = int(request.form["fatigue"])

    disease = predict_disease(
        fever,
        cough,
        headache,
        fatigue
    )

    create_chart(fever, cough, headache, fatigue)

    generate_report(disease)

    return render_template(
        "result.html",
        disease=disease
    )

if __name__ == "__main__":
    app.run(debug=True)