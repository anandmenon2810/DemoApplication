import React from 'react';
import { Container, ListGroup, ListGroupItem } from 'react-bootstrap';
import "./HotelStore.css";
const HotelStore = () => {
    const services = [
        { id: 1, name: 'Room Service', price: '$20 per order' },
        { id: 2, name: 'Laundry', price: '$15 per load' },
        { id: 3, name: 'Spa', price: '$50 per session' },
        // Add more services as needed
    ];

    const products = [
        { id: 1, name: 'Bottle of Water', price: '$2' },
        { id: 2, name: 'Snack Bar', price: '$3' },
        { id: 3, name: 'Travel Adapter', price: '$10' },
        // Add more products as needed
    ];

    return (
        <Container>
            <h1>Hotel Store</h1>
            <h2>Services</h2>
            <ListGroup>
                {services.map(service => (
                    <ListGroupItem key={service.id}>
                        {service.name} - {service.price}
                    </ListGroupItem>
                ))}
            </ListGroup>
            <h2>Products</h2>
            <ListGroup>
                {products.map(product => (
                    <ListGroupItem key={product.id}>
                        {product.name} - {product.price}
                    </ListGroupItem>
                ))}
            </ListGroup>
        </Container>
    );
};

export default HotelStore;
