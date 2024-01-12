import React, { useEffect, useState } from 'react'
import './Style.css'
import axios from 'axios'

function Products() {
    const [productList, setProductList] = useState([])

    useEffect(() => {
        axios.get("http://localhost:4000/product/").then(resp => setProductList(resp.data))
    }, []);

    const handleRows = () => {
        console.log(productList)
        return productList.map(product =>
            <tr key={product.productId}>
                <th scope="row">{product.productId}</th>
                <td>{product.name}</td>
                <td>{product.productType}</td>
                <td></td>
            </tr>
        )
    }

    return (
        <div>
            <table className="table caption-top bg-white rounded mt-2">
                <caption className='text-white fs-4'>List of Aproved Products</caption>
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Product Name</th>
                        <th scope="col">Product Type</th>
                        <th scope="col">Comment</th>
                    </tr>
                </thead>
                <tbody>
                    {handleRows()}
                </tbody>
            </table>
        </div>
    )
}
export default Products