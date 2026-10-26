import matplotlib
matplotlib.use('Agg')

import matplotlib.pyplot as plt

def create_chart(fever, cough, headache, fatigue):

    symptoms = ["Fever", "Cough", "Headache", "Fatigue"]
    values = [fever, cough, headache, fatigue]

    plt.figure(figsize=(5,4))
    plt.bar(symptoms, values)

    plt.title("Symptoms Analysis")
    plt.savefig("static/chart.png")
    plt.close()
    