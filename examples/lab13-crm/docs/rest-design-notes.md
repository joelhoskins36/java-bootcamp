# Lab 13 — REST Design Notes

## 1. Resources

The API has two main resources:

- Customer collection
- Customer item

The Customer collection represents all customers.

The Customer item represents one specific customer identified by `customerId`.

An optional status sub-resource may be used for changing a customer's status.

## 2. URI Table

| Operation | HTTP Method | URI | Purpose |
|---|---|---|---|
| List customers | GET | `/api/v1/customers` | Get all customers |
| Create customer | POST | `/api/v1/customers` | Create a new customer |
| Get customer | GET | `/api/v1/customers/{customerId}` | Get one customer |
| Replace customer | PUT | `/api/v1/customers/{customerId}` | Replace/update a customer |
| Patch status | PATCH | `/api/v1/customers/{customerId}/status` | Change customer status |
| Delete customer | DELETE | `/api/v1/customers/{customerId}` | Delete a customer |

## 3. Version Strategy

This API uses URI versioning:

`/api/v1/...`

For example:

`/api/v1/customers`

The lab uses URI versioning because it makes the API version visible and easy to understand from the request URL.

Header versioning was not chosen for this lab because it would require clients to provide the version through a request header, making the API version less visible when reading or testing URLs.

## Scope

Pre-lab only — do not finish the full graded Lab 13 implementation.

## Part 3
## 4. HTTP Methods and Status Map

| Operation | HTTP Method | Success | Typical Client Errors |
|---|---|---|---|
| List customers | GET | 200 | 400 Bad Query |
| Create customer | POST | 201 + `Location` | 400 Validation, 409 Duplicate |
| Get by ID | GET | 200 | 404 Not Found |
| Replace customer | PUT | 200 | 400 Bad Request, 404 Not Found |
| Patch status | PATCH | 200 | 400 Bad Request, 404 Not Found, 409 Illegal Transition |
| Delete customer | DELETE | 204 | 404 Not Found |

## 5. Safe vs. Idempotent

- `GET` is **safe** because it reads data without changing it.
- `GET` is also idempotent.
- `PUT` is **idempotent** because repeating the same update produces the same final state.
- `DELETE` is **idempotent** because repeating the same delete leaves the resource deleted.
- `POST` is **not idempotent** because sending the same create request multiple times can create multiple customers.

## Scope

Pre-lab only — do not finish the full graded Lab 13 implementation.
## 6. Error Contract

The API uses one structured error response shape for client errors. This gives Angular a consistent format for handling errors instead of requiring different error formats for different endpoints.

### ErrorResponse

```json
{
  "timestamp": "2026-08-23T21:00:00Z",
  "status": 404,
  "error": "Not Found",
  "message": "Customer not found: CUS-9999",
  "path": "/api/v1/customers/CUS-9999",
  "correlationId": "lab-request-001"
}
```

### Error Fields

| Field           | Type    | Purpose                                                              |
| --------------- | ------- | -------------------------------------------------------------------- |
| `timestamp`     | string  | Time when the error occurred                                         |
| `status`        | integer | HTTP status code                                                     |
| `error`         | string  | HTTP status description                                              |
| `message`       | string  | Specific explanation of the error                                    |
| `path`          | string  | API request path that failed                                         |
| `correlationId` | string  | Identifier used to trace the request through application and CI logs |

### Correlation ID

The API documents the `X-Correlation-Id` request header.

Example:

```http
X-Correlation-Id: lab-request-001
```

The same correlation ID is returned in the `ErrorResponse` as `correlationId`.

This allows a request to be traced across the client, Spring Boot application logs, and CI/test logs.

### Error Examples

* `400 Bad Request` — invalid request data or query parameters
* `404 Not Found` — requested customer does not exist
* `409 Conflict` — duplicate customer or illegal status transition

## Scope

Pre-lab only — do not finish the full graded Lab 13 implementation.

## 7. Pagination, Filtering, and Sorting

The customer list endpoint uses query parameters for pagination, filtering, and sorting.

### Query Parameters

| Parameter | Description                          | Default / Allowed Values                           |
| --------- | ------------------------------------ | -------------------------------------------------- |
| `page`    | Zero-based page number               | `0`                                                |
| `size`    | Number of customers per page         | `20`, maximum `100`                                |
| `status`  | Filter customers by status           | `ACTIVE`, `PROSPECT`, or other documented statuses |
| `sort`    | Field and direction used for sorting | Example: `fullName,asc`                            |

### Example Request

```http
GET /api/v1/customers?status=ACTIVE&page=0&size=20&sort=fullName,asc
```

This request returns the first page of ACTIVE customers, with up to 20 customers, sorted by `fullName` in ascending order.

### Page Response

The list endpoint returns a page wrapper instead of returning only an array of customers.

Example:

```json
{
  "content": [
    {
      "id": "CUS-1001",
      "name": "Alice Smith",
      "email": "alice@example.com",
      "status": "ACTIVE"
    }
  ],
  "page": 0,
  "size": 20,
  "totalElements": 1
}
```

### Page Fields

| Field           | Purpose                                       |
| --------------- | --------------------------------------------- |
| `content`       | Customers included in the requested page      |
| `page`          | Current zero-based page number                |
| `size`          | Requested page size                           |
| `totalElements` | Total number of customers matching the filter |

### Design Rules

* Pages are zero-based.
* The default page size is 20.
* The maximum page size is 100.
* `status` can filter the customer collection.
* `sort` specifies both the field and direction.
* This API uses page/size pagination for the course rather than designing a custom offset-based pagination system.

## Scope

Pre-lab only — do not finish the full graded Lab 13 implementation.




