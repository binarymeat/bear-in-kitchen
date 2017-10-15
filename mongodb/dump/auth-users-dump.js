print('dump start');

db.users.update(
    {
        "username": "rob",
        "password": "$2a$04$a9RgI/6q73orOILQ0PDSVeGG4ZVT0M1jy.D9huIiY7CCp/PIhfWrm"
    },
    {
        "username": "bob",
        "password": "$2a$04$a9RgI/6q73orOILQ0PDSVeGG4ZVT0M1jy.D9huIiY7CCp/PIhfWrm"
    },
    { upsert: true }
);

print('dump complete');