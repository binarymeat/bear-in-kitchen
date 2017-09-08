print('dump start');

db.accounts.update(
    { "_id": "demo" },
    {
        "_id": "demo",
        "lastSeen": new Date(),
        "note": "demo note",
        "expenses": [
            {
                "amount": 1300,
                "currency": "USD",
                "icon": "home",
                "period": "MONTH",
                "title": "Rent"
            }

        ],
        "incomes": [
            {
                "amount": 42000,
                "currency": "USD",
                "icon": "wallet",
                "period": "YEAR",
                "title": "Salary"
            },
            {
                "amount": 500,
                "currency": "USD",
                "icon": "edu",
                "period": "MONTH",
                "title": "Scholarship"
            }
        ],
        "saving": {
            "amount": 5900,
            "capitalization": false,
            "currency": "USD",
            "deposit": true,
            "interest": 3.32
        }
    },
    { upsert: true }
);

print('dump complete');