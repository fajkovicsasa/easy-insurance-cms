MERGE INTO INSURANCE_TYPES
VALUES (1, 'Bike',
        'Do not worry ever again about your bike being stolen.<br>I want to ride my bicycle, races are coming your way.',
        30, 0, 3000, 'https://live.staticflickr.com/7358/26799908181_5f13291dd7_b.jpg');
MERGE INTO INSURANCE_TYPES
VALUES (2, 'Jewelry',
        'Gold, Silver, Bronze, Platinum or any other valuable piece can be insured so you can enjoy those fabulous nights out',
        5, 500, 10000, 'https://torange.biz/photo/18/IMAGE/love-jewellery-pearls-jewelry-as-gift-18274.jpg');
MERGE INTO INSURANCE_TYPES
VALUES (3, 'Electronics',
        'Don''t let the thunderstorm surprise you. Insure your precious electronic devices and enjoy your free time stress free.',
        35, 500, 6000, 'https://media.defense.gov/2013/Mar/17/2000066969/780/780/0/130315-F-ME639-015.JPG');
MERGE INTO INSURANCE_TYPES
VALUES (4, 'Sports Equipment',
        'Something went missing while you were taking a shower after a hard training? We have you covered.', 30, 0,
        20000, 'https://cdn.pixabay.com/photo/2018/04/28/16/37/sport-3357630_960_720.jpg');

MERGE INTO USERS VALUES ( 1, 'admin', '1234', 'Sasa', 'Fajkovic', 'fajkovic.sasa@gmail.com', true, true, true );
MERGE INTO USERS VALUES ( 2, 'userActive', '1234', 'User', 'Active', 'user.active@gmail.com', true, false, true );
MERGE INTO USERS VALUES ( 3, 'userInactive', '1234', 'User', 'Inactive', 'user.inactive@gmail.com', true, false, false );