import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import ProductList from './ProductList'
import CategoryFilter from './CategoryFilter'


function App() {
  const [products, setProducts] = useState([]);   //React Hook (useState) that creates a state variable called Product and a function setProducts to update it.
                                                //Initially, Product is an empty array [].
  const [categories, setCategories] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState(null);
  const [searchTerm , setSearchTerm] = useState("");
  const [sortOrder, setSortOrder] = useState("asc");

  useEffect(() => {                              //useEffect is another React Hook that  - in this case, fetching data from an API.
                                                 //The empty dependency array [] means this effect runs only once, when the component mounts (like componentDidMount in class components).

    fetch('http://localhost:8080/api/products')  //fetch('http://localhost:8080/api/products') sends a GET request to your backend.
    .then(response => response.json())           //.then(response => response.json()) parses the JSON response.
    .then(data => setProducts(data))             //.then(data => setProducts(data)) updates the state with the fetched product data.

     fetch('http://localhost:8080/api/categories')  
    .then(response => response.json())           
    .then(data => setCategories(data))   
  }, []);

  const handleSearchChange  = (event) =>{
    setSearchTerm(event.target.value);
  };

   const handleSortChange  = (event) =>{
    setSortOrder(event.target.value);
  };

  const handleCategorySelect = (categoryId) =>
  {
    setSelectedCategory(categoryId ? Number(categoryId): null); 
  };
  
  const filteredProduct = products 
              .filter(product => {
                return(
                  (selectedCategory ? product.category.id === selectedCategory : true)
                  &&
                  product.name.toLowerCase().includes(searchTerm.toLowerCase())
                )
                })
                .sort((a,b) => {
                  if(sortOrder === "asc"){
                    return a.price - b.price ;
                  }
                  else{
                    return b.price- a.price;
                  }
              });
  return (
    <div className='container'>
      <h1 className='my-4'>Product Catalog</h1>

        <div className='row align-items-center mb-4'>
          <div className='col-md-3 col-sm-12 mb-12'>
           <CategoryFilter categories={categories} onSelect={handleCategorySelect}/>
          </div>
          <div className='col-md-5 col-sm-12 mb-12'>
             <input
            type='text'
            className='form-control'
            placeholder='Search for products'
            onChange={handleSearchChange}>
            
          </input>
          </div>
           <div className='col-md-4 col-sm-12 mb-2'>
                  
          <select className='form-control' onChange={handleSortChange}>
           <option value={"asc"}>Sort By Price: Low to High</option>
           <option value={"desc"}>Sort By Price: High to Low</option>
          </select>
        </div>
        </div>
       
     <div>

         {filteredProduct.length ? (
            // Display products
            <ProductList products = {filteredProduct}/>
          ) :
          (
            <p>No Products found</p>
          )}
     </div>
    </div>
  )
}

export default App
