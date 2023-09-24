import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Header from '../src/Compontents/Header/Header'
import { Footer } from './Compontents/Footer/Footer';
import Home from './Compontents/Home/Home';
import Register from './Compontents/Auth/Register';
import Login from './Compontents/Auth/Login';
function App() {
  return (
    <BrowserRouter>
      <Header />
        <Routes>
          <Route path='/home' element={<Home />} />
          <Route path='/register' element={<Register />} />
          <Route path='/' element={<Login />} />
        </Routes>
      <Footer />
    </BrowserRouter>
  );
}

export default App;
