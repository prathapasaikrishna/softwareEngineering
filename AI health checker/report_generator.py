def generate_report(disease):

    report = f"""
AI HEALTH REPORT

Predicted Disease : {disease}

Recommendation:
Drink enough water.
Take proper rest.
Consult a doctor if symptoms persist.
"""

    with open(
        "reports/health_report.txt",
        "w"
    ) as file:
        file.write(report)