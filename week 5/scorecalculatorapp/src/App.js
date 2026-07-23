import React from 'react';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div className="App">
      <CalculateScore
        Name="Rahul Sharma"
        School="Green Valley Public School"
        Total={450}
        goal={5}
      />
    </div>
  );
}

export default App;