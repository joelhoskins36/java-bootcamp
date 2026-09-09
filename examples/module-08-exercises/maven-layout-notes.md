# Maven Layout Notes

## Step 1 — Classify these files

| File                                       | Destination                         |
| ------------------------------------------ | ----------------------------------- |
| `Customer.java`                            | `src/main/java/com/northstar/crm/`  |
| `CustomerServiceTest.java`                 | `src/test/java/com/northstar/crm/`  |
| `application.properties`                   | `src/main/resources/`               |
| `sample-customers.json` used only by tests | `src/test/resources/`               |
| `CODING-STANDARDS.md`                      | `docs/`                             |
| `Customer.class`                           | `target/classes/com/northstar/crm/` |

## Step 2 — Check your answers

* Production Java code belongs in `src/main/java/`.
* Test Java code belongs in `src/test/java/`.
* Application configuration belongs in `src/main/resources/`.
* Test-only resources belong in `src/test/resources/`.
* Documentation belongs in `docs/`.
* Compiled/generated files belong under `target/`.

## Step 3 — Explain `target/`

`target/` is generated from source by Maven. It can be deleted and rebuilt, so it should be ignored rather than committed.
