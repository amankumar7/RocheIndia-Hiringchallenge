# Spring Boot REST API Example

This project demonstrates a Spring Boot application with a REST API and a statistics endpoint.

## API Endpoints:

### 1. Generate List

Endpoint: `/api/v1/strings`

Accepts five mandatory parameters:
- `int1` (integer)
- `int2` (integer)
- `limit` (integer)
- `str1` (string)
- `str2` (string)

Returns a list of strings containing numbers from 1 to `limit`. Replaces multiples of `int1` with `str1`, multiples of `int2` with `str2`, and multiples of both `int1` and `int2` with `str1str2`.

### 2. Statistics

Endpoint: `/api/v1/statistics`

Accepts no parameters. Returns the parameters corresponding to the most used request, including the number of hits for the most frequent request.

## How to Run:

1. Clone the repository: `git clone https://github.com/amankumar7/RocheIndia-Hiringchallenge.git`
2. Navigate to the project directory: `cd RocheIndia-Hiringchallenge`
3. Build the project: `./gradlew build`
4. Run the application: `./gradlew bootRun`

Visit `http://localhost:8080` in your browser or a tool like Postman to test the endpoints.

## Unit Tests:

Run unit tests using the following command:

```bash
./gradlew test


