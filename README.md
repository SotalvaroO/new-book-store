# Requirements

- **Docker** installed on your system
- **Docker Compose**  
   For installation instructions, see the official [Docker Compose installation guide](https://docs.docker.com/compose/install/).
- **Java 17** and **Maven**

## Steps to Create and Run the Application Using Docker Compose

1. **Start the Application with Docker Compose**  
   Run the following command in the project root to build the images and start the application in detached mode:
   ```sh
   docker compose up --build -d
   ```

> Once the application is running, it will be served at [http://localhost:8080](http://localhost:8080).  
> For details on available endpoints, see the API Documentation section below.

## (DOCKER ONLY) Steps to Create and Run the application using docker

> **Note:** Skip these steps if you chose the Docker Compose method above.

1. **Build the Docker Image**  
   Open a terminal in the project root folder and run:

   ```sh
   docker build -t new-book-store .
   ```

2. **Configure Environment Variables**

   - Make a copy of `example.env` and rename it to `.env`.
   - Open the `.env` file and update the following properties with your database details:

   ```
   DATABASE_URL=your_database_url
   DATABASE_USERNAME=your_database_username
   DATABASE_PASSWORD=your_database_password
   ```

3. **Run the Docker Container**  
   Execute the following command to start the container:

   ```sh
   docker run -p 8080:8080 --env-file ./.env new-book-store
   ```

## API Documentation: Books Controller

### Base URL

```
http://localhost:8080
```

### Endpoints

#### 1. Get All Books

- **GET** `/books`
- **Description:** Retrieve a list of all books.
- **Response:**
  ```json
  [
    {
      "title": "Book Title",
      "author": "Author Name",
      "isbn": "1234567890",
      "publicationYear": 2025
    }
  ]
  ```

#### 2. Get Book by ISBN code

- **GET** `/books/{isbn}`
- **Description:** Retrieve details of a specific book by its ISBN code.
- **Response:**
  ```json
  {
    "title": "Book Title",
    "author": "Author Name",
    "isbn": "1234567890",
    "publicationYear": 2025
  }
  ```

#### 3. Create a New Book

- **POST** `/books`
- **Description:** Add a new book.
- **Request Body:**
  ```json
  {
    "title": "New Book",
    "author": "Author Name",
    "isbn": "1234567890",
    "publicationYear": 2025
  }
  ```
- **Response:**
  ```json
  {
    "title": "New Book",
    "author": "Author Name",
    "isbn": "1234567890",
    "publicationYear": 2025
  }
  ```

#### 4. Update a Book

- **PUT** `/books/{isbn}`
- **Description:** Update an existing book's details.
- **Request Body:**
  ```json
  {
    "title": "Updated Title",
    "author": "Updated Author",
    "isbn": "0987654321",
    "publicationYear": 2025
  }
  ```
- **Response:**
  ```json
  {
    "title": "Updated Title",
    "author": "Updated Author",
    "isbn": "0987654321",
    "publicationYear": 2025
  }
  ```

#### 5. Delete a Book

- **DELETE** `/books/{isbn}`
- **Description:** Remove a book by its ISBN code.
- **Response:**
  - Status: `204 No Content`
