import React from 'react'
import './Style.css'

function Products() {
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
                    <tr>
                        <th scope="row">1</th>
                        <td>Coca-Cola</td>
                        <td>Drink</td>
                        <td></td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>Cow</td>
                        <td>Food</td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
        </div>
    )
}
export default Products