# Package Plan

## Step 1 — Complete the Map

| Type                        | Package                        | Fully Qualified Name                                    |
| --------------------------- | ------------------------------ | ------------------------------------------------------- |
| `CustomerController`        | `com.northstar.crm.controller` | `com.northstar.crm.controller.CustomerController`       |
| `CustomerService`           | `com.northstar.crm.service`    | `com.northstar.crm.service.CustomerService`             |
| `CustomerRepository`        | `com.northstar.crm.repository` | `com.northstar.crm.repository.CustomerRepository`       |
| `Customer`                  | `com.northstar.crm.entity`     | `com.northstar.crm.entity.Customer`                     |
| `CustomerRequest`           | `com.northstar.crm.dto`        | `com.northstar.crm.dto.CustomerRequest`                 |
| `AppConfig`                 | `com.northstar.crm.config`     | `com.northstar.crm.config.AppConfig`                    |
| `CustomerNotFoundException` | `com.northstar.crm.exception`  | `com.northstar.crm.exception.CustomerNotFoundException` |

## Step 2 — Package Rules

* Package names use lowercase letters.
* The root package uses the reverse-domain convention: `com.northstar.crm`.
* Classes use PascalCase, such as `CustomerService`.
* Package folders must match the package declaration.
* Packages should describe the responsibility of the classes they contain.
* Enterprise code should avoid using the default package.

## Step 3 — Translate Package to Path

For the package:

`com.northstar.crm.dto`

the matching production source directory is:

`src/main/java/com/northstar/crm/dto/`

Therefore, the path for `CustomerRequest` is:

`src/main/java/com/northstar/crm/dto/CustomerRequest.java`

The package declaration inside the file would be:

```java
package com.northstar.crm.dto;
```

## Step 4 — Correct Bad Names

| Bad                                        | Correct                                            |
| ------------------------------------------ | -------------------------------------------------- |
| `com.Northstar.CRM.Service`                | `com.northstar.crm.service`                        |
| `utils` for customer business rules        | `service` or another focused domain package        |
| `customer_service.java`                    | `CustomerService.java`                             |
| Package declaration does not match folders | Make the package declaration and folder path match |

## Debug / Design Challenge

`com.Northstar.CRM` should be changed to:

`com.northstar.crm`

Package names are conventionally lowercase. Using lowercase package segments keeps naming consistent and makes the package structure predictable.

## Predict the Output / Behavior

The package:

`com.northstar.crm.service`

matches this folder path:

`src/main/java/com/northstar/crm/service/`

## Expected Result

All seven types have focused packages, valid fully qualified names, and matching source paths.
