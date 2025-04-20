import React, { useState } from "react";
import axios from "axios";


console.log("App component loaded!");


function App() {
  const [formData, setFormData] = useState({
    location: "",
    size: "",
    bedrooms: "",
    bathrooms: "",
  });

  const [prediction, setPrediction] = useState(null);

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const res = await axios.post("http://localhost:6900/api/predict", formData);
      setPrediction(res.data.prediction);
    } catch (error) {
      console.error("Error making prediction:", error);
    }
  };

  return (
    <div style={{ padding: "2rem", fontFamily: "Arial" }}>
      <h2>Rental Price Predictor</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Location: </label>
          <input
            type="text"
            name="location"
            value={formData.location}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label>Size (sqft): </label>
          <input
            type="number"
            name="size"
            value={formData.size}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label>Bedrooms: </label>
          <input
            type="number"
            name="bedrooms"
            value={formData.bedrooms}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label>Bathrooms: </label>
          <input
            type="number"
            name="bathrooms"
            value={formData.bathrooms}
            onChange={handleChange}
            required
          />
        </div>
        <button type="submit">Predict Price</button>
      </form>
      {prediction && (
        <h3>Predicted Monthly Rent: ₹{prediction}</h3>
      )}
    </div>
  );
}

export default App;
