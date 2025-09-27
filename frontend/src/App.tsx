import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import Products from './pages/Products';
import Create from './pages/Create';

function App() {

  return (
     <BrowserRouter>
      <Routes>
        <Route path="/" element={<Products />} />
        <Route path="/create" element={<Create />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;

