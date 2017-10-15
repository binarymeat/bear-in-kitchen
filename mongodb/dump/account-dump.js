print('dump start');

db.accounts.update(
    {
        "_id": "rob",
        "lastSeen": new Date()
    },
    {
        "_id": "bob",
        "lastSeen": new Date()
    },
    { upsert: true }
);

print('dump complete');