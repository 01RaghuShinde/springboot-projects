import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error, r2_score

# Load the dataset 
data_path = 'FINAL_USO.csv'  
data = pd.read_csv(data_path)

# Display the first few rows of the data to understand its structure
print(data.head())

# Select features and target
# Assuming 'Date' is not needed for regression and 'Adjusted Close' is the target variable.
features = data[['SP_Ajclose', 'OF_Price', 'USDI_Price', 'EG_Ajclose', 'DJ_Ajclose']]  # Choose relevant features
target = data['GDX_Adj Close']  # Adjusted Close Price of Gold ETF

# Handle missing values (if any)
features = features.fillna(features.mean())  # Fill missing values with column mean
target = target.fillna(target.mean())

# Split the data into training and testing sets
X_train, X_test, y_train, y_test = train_test_split(features, target, test_size=0.2, random_state=42)

# Initialize and train the Linear Regression model
model = LinearRegression()
model.fit(X_train, y_train)

# Predict the values
y_pred = model.predict(X_test)

# Evaluate the model
mse = mean_squared_error(y_test, y_pred)
r2 = r2_score(y_test, y_pred)

# Print the evaluation metrics
print(f"Mean Squared Error: {mse}")
print(f"R² Score: {r2}")

# Visualize the results: Scatter plot with regression line
plt.figure(figsize=(10, 6))
plt.scatter(y_test, y_pred, color='blue', alpha=0.5, label="Actual vs Predicted")
plt.plot([min(y_test), max(y_test)], [min(y_pred), max(y_pred)], color='red', linewidth=2, label="Regression Line")

# Set labels and title
plt.xlabel('Actual Adjusted Close Price')
plt.ylabel('Predicted Adjusted Close Price')
plt.title('Linear Regression: Actual vs Predicted Gold ETF Prices')
plt.legend()
plt.show()
