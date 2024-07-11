import React from 'react';
import { Card, Col, Form, Button } from 'react-bootstrap';
const Addfunds = () => {
    return (
        <Card>
            <Card.Body>
                <Form>
                    <Form.Group controlId="formCardNumber">
                        <Form.Label>Card Number</Form.Label>
                        <Form.Control type="text" placeholder="Enter card number" />
                    </Form.Group>

                    <Form.Group controlId="formCardName">
                        <Form.Label>Cardholder Name</Form.Label>
                        <Form.Control type="text" placeholder="Enter cardholder name" />
                    </Form.Group>

                    <Form.Row>
                        <Form.Group as={Col} controlId="formCardExpiry">
                            <Form.Label>Expiration Date</Form.Label>
                            <Form.Control type="text" placeholder="MM/YY" />
                        </Form.Group>

                        <Form.Group as={Col} controlId="formCardCVV">
                            <Form.Label>CVV</Form.Label>
                            <Form.Control type="text" placeholder="CVV" />
                        </Form.Group>
                    </Form.Row>

                    <Button variant="primary" type="submit">
                        Submit
                    </Button>
                </Form>
            </Card.Body>
         </Card>
    );
};

export default Addfunds;