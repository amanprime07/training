import pandas as pd

# Data extracted from the PDF content
data = [
    ]

# Corrected column names - combining the two header rows
corrected_columns = [
]

# Create a DataFrame
df = pd.DataFrame(data[2:], columns=corrected_columns)

# Display the DataFrame in markdown format
print(df.to_markdown(index=False, numalign="left", stralign="left"))