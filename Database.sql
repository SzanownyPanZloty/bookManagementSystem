CREATE Database booksDB;
use booksDB;

DROP TABLE IF EXISTS `books`;
create table books
(
    bookId          int auto_increment
        primary key,
    bookName        varchar(255) not null,
    bookAuthor      varchar(255) not null,
    bookGenre       varchar(255) not null,
    bookYear        int          not null,
    bookDescription text         not null
);

INSERT INTO books (bookId, bookName, bookAuthor, bookGenre, bookYear, bookDescription) VALUES (1, 'Echoes of Eternity', 'Aurora Montgomery', 'Fiction', 2024, 'In a world full of magic and dangers, a young wizard faces his greatest trial yet to save the kingdom from darkness.');
INSERT INTO books (bookId, bookName, bookAuthor, bookGenre, bookYear, bookDescription) VALUES (2, 'Whispers in the Wind', 'Benjamin Hayes', 'Novel', 2023, 'A romantic saga set against the tumultuous backdrop of the 1920s, where love and betrayal intertwine into an intriguing story.');
INSERT INTO books (bookId, bookName, bookAuthor, bookGenre, bookYear, bookDescription) VALUES (3, 'The Midnight Serenade', 'Yvette Johnson', 'Novel', 2024, 'A whimsical comedy of manners that follows the lives of two extraordinary heroines trying to find their place in the crazy world of showbiz.');
INSERT INTO books (bookId, bookName, bookAuthor, bookGenre, bookYear, bookDescription) VALUES (4, 'Shadows of Solitude', 'Damien Blackwood', 'Fiction', 2024, 'A fantasy epic where a group of extraordinary travelers embarks on a quest to stop the apocalypse and find a lost artifact.');
INSERT INTO books (bookId, bookName, bookAuthor, bookGenre, bookYear, bookDescription) VALUES (5, 'Dreams of the Forgotten', 'Eliza Rivers', 'Thriller', 2021, 'A touching tale of friendship and loyalty that transcends generations, filled with emotional moments and unforgettable characters.');
INSERT INTO books (bookId, bookName, bookAuthor, bookGenre, bookYear, bookDescription) VALUES (6, 'The Enigma of Echo Lake', 'Felix Thompson', 'Non-Fiction', 2021, 'An extraordinary biography of a legendary artist who broke all barriers to express his creativity and become a cultural icon.');
INSERT INTO books (bookId, bookName, bookAuthor, bookGenre, bookYear, bookDescription) VALUES (7, 'Chronicles of the Celestial Sphere', 'Gabrielle Martinez', 'Science Fiction', 2024, 'A thrilling suspense novel full of twists and secrets, where a private detective gets entangled in a conspiracy that threatens not only his life but the entire city.');
INSERT INTO books (bookId, bookName, bookAuthor, bookGenre, bookYear, bookDescription) VALUES (8, 'Lost in Luminescence', 'Harrison Clarke', 'Fiction', 2024, 'A sensational science fiction novel where characters must confront an unknown threat from space to ensure the survival of humanity.');
INSERT INTO books (bookId, bookName, bookAuthor, bookGenre, bookYear, bookDescription) VALUES (9, 'Beyond the Veil of Time', 'Isabelle Bennett', 'Crime', 2024, 'An intriguing love story set in a mysterious estate on the outskirts of town, where the past still harbors dark secrets.');
INSERT INTO books (bookId, bookName, bookAuthor, bookGenre, bookYear, bookDescription) VALUES (10, 'Songs of the Siren', 'Jonah Anderson', 'Crime', 2023, 'An educational children\'s book where a young explorer embarks on a journey through the natural world, discovering fascinating natural phenomena.');
INSERT INTO books (bookId, bookName, bookAuthor, bookGenre, bookYear, bookDescription) VALUES (11, 'The Forgotten Kingdom', 'Aurora Montgomery', 'Crime', 2023, 'A humorous tale of a group of friends who decide to start an unconventional venture, facing both comedic and serious challenges along the way.');
INSERT INTO books (bookId, bookName, bookAuthor, bookGenre, bookYear, bookDescription) VALUES (12, 'Echoes from the Abyss', 'Aurora Montgomery', 'Mystery', 2023, 'An extraordinary psychological study that explores the complex relationships between people, revealing the dark corners of the human soul.');
INSERT INTO books (bookId, bookName, bookAuthor, bookGenre, bookYear, bookDescription) VALUES (13, 'The Serpent\'s Song', 'Marissa Sullivan', 'Crime', 2023, 'A tale of destiny and courage where a heroine must confront her greatest fears to save what is most precious.');
INSERT INTO books (bookId, bookName, bookAuthor, bookGenre, bookYear, bookDescription) VALUES (14, 'Whispers of the Moon', 'Nathanial Parker', 'Mystery', 2024, 'A bittersweet domestic novel that weaves a story about a family struggling with life\'s difficulties and trying to find the path to happiness.');
INSERT INTO books (bookId, bookName, bookAuthor, bookGenre, bookYear, bookDescription) VALUES (15, 'The Illusionist\'s Apprentice', 'Olivia Adams', 'History', 2024, 'An adventurous young adult story that takes the reader on a journey through a fantastical world full of magical creatures and extraordinary adventures.');
INSERT INTO books (bookId, bookName, bookAuthor, bookGenre, bookYear, bookDescription) VALUES (16, 'Tales from the Forgotten Realm', 'Patrick Gallagher', 'History', 2024, 'A dramatic story based on true events, depicting a hero\'s struggle for survival in a world full of adversity and danger.');
INSERT INTO books (bookId, bookName, bookAuthor, bookGenre, bookYear, bookDescription) VALUES (17, 'Secrets of the Starlight Chamber', 'Quinn Roberts', 'Mystery', 2021, 'A gripping political thriller where a special agent is drawn into a dangerous game of power and influence at the highest levels of government.');
INSERT INTO books (bookId, bookName, bookAuthor, bookGenre, bookYear, bookDescription) VALUES (18, 'The Enchanted Labyrinth', 'Rebecca Nelson', 'Fiction', 2024, 'An inspiring tale of the resilience of the human spirit that endured the toughest moments in history, leaving indelible marks behind.');
INSERT INTO books (bookId, bookName, bookAuthor, bookGenre, bookYear, bookDescription) VALUES (19, 'Echoes of the Eternal Forest', 'Sebastian Ramirez', 'Mystery', 2024, 'A romantic novel where characters must overcome obstacles and the twists of fate to find true happiness in love.');
INSERT INTO books (bookId, bookName, bookAuthor, bookGenre, bookYear, bookDescription) VALUES (20, 'The Celestial Codex', 'Damien Blackwood', 'History', 2024, 'An exploratory travel book that invites the reader on an extraordinary journey through exotic landscapes and fascinating cultures.');
INSERT INTO books (bookId, bookName, bookAuthor, bookGenre, bookYear, bookDescription) VALUES (21, 'Whispers of the Winter Woods', 'Damien Blackwood', 'History', 2023, 'A poignant tale of human tragedies and heroic deeds that sheds light on the darkest corners of human nature.');
INSERT INTO books (bookId, bookName, bookAuthor, bookGenre, bookYear, bookDescription) VALUES (22, 'The Alchemist\'s Daughter', 'Damien Blackwood', 'Fiction', 2023, 'A fantastic family saga where characters must confront a curse that has haunted their lineage for generations.');
INSERT INTO books (bookId, bookName, bookAuthor, bookGenre, bookYear, bookDescription) VALUES (23, 'Chronicles of the Crimson Kingdom', 'Xander Morgan', 'Mystery', 2021, 'An intriguing crime novel that weaves a complicated web of lies and intrigues, while a detective tries to uncover the truth.');
INSERT INTO books (bookId, bookName, bookAuthor, bookGenre, bookYear, bookDescription) VALUES (24, 'The Oracle\'s Prophecy', 'Yvette Johnson', 'Crime', 2021, 'An educational children\'s story that teaches about the values of friendship, courage, and respect through the amusing adventures of the main characters.');
INSERT INTO books (bookId, bookName, bookAuthor, bookGenre, bookYear, bookDescription) VALUES (25, 'Echoes of the Fallen', 'Gabrielle Martinez', 'Fiction', 2021, 'An epic fantasy tale of the battle between good and evil, where the fate of worlds depends on the courage and determination of the heroes in the face of adversity.');
