import pandas as pd
from sklearn.tree import DecisionTreeClassifier

df = pd.read_excel("dataset.xlsx")

X = df.drop("Disease", axis=1)
y = df["Disease"]

model = DecisionTreeClassifier()
model.fit(X, y)

def predict_disease(fever, cough, headache, fatigue):
    prediction = model.predict(
        [[fever, cough, headache, fatigue]]
    )

    return prediction[0]