-- ACCOUNT
DO $$
DECLARE
account_id INTEGER;
BEGIN
BEGIN
        -- Create account
INSERT INTO "account" (name, account_type) VALUES ('test account', 'Cash') RETURNING id INTO account_id;

-- Insert into balance_history
INSERT INTO "balance_history" (accountId) VALUES (account_id);

-- Commit the transaction
COMMIT;
EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            RAISE;
END;
END $$;

-- TRANSACTION
DO $$
DECLARE
amount_value NUMERIC;
BEGIN
BEGIN
        -- Credit Account
UPDATE "account" SET balance = balance + 'AMOUNT' WHERE id = account_id RETURNING balance INTO amount_value;

-- Insert into balance_history
INSERT INTO "balance_history" (value, accountId) VALUES (amount_value, account_id);

-- Insert into transaction
INSERT INTO "transaction" (label, amount, transactiontype, accountId) VALUES ('Salary', 'AMOUNT', 'CREDIT', account_id);

-- Debit Account
UPDATE "account" SET balance = balance - 'AMOUNT' WHERE id = account_id RETURNING balance INTO amount_value;

-- Insert into balance_history
INSERT INTO "balance_history" (value, accountId) VALUES (amount_value, account_id);

-- Insert into transaction
INSERT INTO "transaction" (label, amount, transactiontype, accountId) VALUES ('Gift', 'AMOUNT', 'DEBIT', account_id);

-- Commit the transaction
COMMIT;
EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            RAISE;
END;
END $$;

-- BALANCE HISTORY OF AN ACCOUNT
SELECT bh.lastupdate, bh.value
FROM "account" a
         INNER JOIN "balance_history" bh ON bh.accountid = a.id
WHERE a.id = account_id;

-- Sum of cash inflows and outflows between the given date range
SELECT (
               SUM(CASE WHEN tr.transactiontype = 'DEBIT' THEN 'DEBIT' ELSE 0 END) -
               SUM(CASE WHEN tr.transactiontype = 'CREDIT' THEN 'CREDIT' ELSE 0 END)
           ) AS total_amount
FROM "balance_history" bh
         INNER JOIN "account" acc ON acc.id = bh.accountid
         INNER JOIN "transaction" tr ON tr.accountid = acc.id
WHERE bh.accountId = account_id
  AND updateDateTime BETWEEN 'START_DATE' AND 'END_DATE';

-- Sum of cash inflows and outflows between the given date range with transaction category
SELECT c.id AS category_id,
       c.name AS category_name,
       (SUM(CASE WHEN bh.value IS NOT NULL THEN bh.value ELSE 0 END)) AS total_amount
FROM "category" c
         LEFT JOIN "transaction" tr ON tr.categoryid = c.id
         LEFT JOIN "account" acc ON acc.id = tr.accountid
         LEFT JOIN "balance_history" bh ON bh.accountid = acc.id
    AND bh.accountId = account_id
    AND bh.updateDateTime BETWEEN  'START_DATE' AND 'END_DATE'
GROUP BY c.id, c.name;
