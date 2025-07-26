USE lytlestory;

INSERT INTO lytlestory.stories (id, title, author, genre, file_name)
SELECT UUID_TO_BIN(UUID()), title, author, genre, file_name
FROM (
    SELECT 'Boule De Suif' AS title, 'Guy de Maupassant' AS author, 'Realism' AS genre, 'boule_de_suif' AS file_name UNION ALL
    SELECT 'Gift of the Magi', 'O. Henry', 'Magic Realism', 'gift_of_the_magi' UNION ALL
    SELECT 'The Cop and the Anthem', 'O. Henry', 'Realism', 'the_cop_and_the_anthem' UNION ALL
    SELECT 'The Last Leaf', 'O. Henry', 'Realism', 'the_last_leaf' UNION ALL
    SELECT 'The Story of an Hour', 'Kate Chopin', 'Realism', 'the_story_of_an_hour' UNION ALL
    SELECT 'Desiree''s Baby', 'Kate Chopin', 'Realism', 'desirees_baby' UNION ALL
    SELECT 'The Bet', 'Anton Chekhov', 'Realism', 'the_bet' UNION ALL
    SELECT 'The Legend of Sleepy Hollow', 'Washington Irving', 'Realism', 'legend_of_sleepy_hollow' UNION ALL
    SELECT 'The Tell-Tale Heart', 'Edgar Allan Poe', 'Horror', 'the_tell_tale_heart'
) AS stories_data;
