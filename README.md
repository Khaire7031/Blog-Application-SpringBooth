# Website Hit Counter System

The Website Hit Counter System is a backend application designed to track visits to a website by different customers using multiple devices. It implements a publisher-subscriber notification system to ensure accurate tracking of website visits. The system allows for the tracking of visits by unique customers, regardless of the device they use.

## Features

- **Visit Tracking**: Tracks visits to a website by specific customers using their unique identifiers (customer ID) and devices (device ID).
- **Customer-Centric**: Each customer is uniquely identified, allowing for accurate counting of visits across different devices.
- **Overall Visit Count**: Provides the total number of visits to a specific website by all customers.
- **Flexible API**: Offers RESTful API endpoints to interact with the system, allowing for easy integration with frontend applications or other services.

## Technologies Used

- **Node.js**: The backend is built using Node.js, providing a scalable and efficient runtime environment for JavaScript-based applications.
- **Express.js**: Express.js is used as the web application framework for Node.js, simplifying the creation of RESTful APIs and handling HTTP requests.
- **In-Memory Data Storage**: The system utilizes internal data structures to store visit data, eliminating the need for external databases or services.
- **Postman**: Postman is used for API development, testing, and documentation, providing a comprehensive platform for building and collaborating on APIs.

## Project Structure

The project follows a modular structure with separate components for controllers, models, and routes. Each component is responsible for handling specific aspects of the application, ensuring clean separation of concerns and maintainability.

website-hit-counter/
├── node_modules/
├── src/
│ ├── controllers/
│ │ └── visitController.js
│ ├── models/
│ │ └── visitModel.js
│ ├── routes/
│ │ └── visitRoutes.js
│ ├── app.js
│ └── server.js
├── .env
├── .gitignore
├── package.json
├── package-lock.json
└── README.md


## Setup Instructions

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/website-hit-counter.git
   cd website-hit-counter

''' npm install

''' PORT=3000

''' npm start

