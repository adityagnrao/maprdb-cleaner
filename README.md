# maprdb-cleaner
A small tool to clean MapR-DB based on queries


### Installation

```bash
brew install https://raw.githubusercontent.com/anicolaspp/maprdb-cleaner/master/maprdb-cleaner.rb
```

`maprdbcls` requires `java 1.8+`.


### Usage

- Deletes document with `_id` equals to `-1016518206699135554`.

```bash
maprdbcls -t /user/mapr/tables/rnd -q '{"$where": {"$eq": {"_id": "-1016518206699135554"}}}'
```

- Deletes all documents.

```bash
maprdbcls -t /user/mapr/tables/rnd --all
```

- Deletes all documents using id `custom_id_field`.

```bash
maprdbcls -t /user/mapr/tables/rnd --all --id custom_id_field 
```

- Delete first 20 users which `age` is less than `10`.

```bash
maprdbcls -t /user/mapr/tables/users --query '{"$where": {"$lt": {"age": 10}}, "$limit": 20}'
```
 
`maprdbcls` executes `maprdbcls-1.0.0.jar` passsing the class path `/opt/mapr/lib/*`, so `MapR` client should 
be installed in this path (defaults). 
