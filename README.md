# Drummee
The multipurpose futuristic CUI rubix cube 

help:
Drumme has multiple uses,
 the gist of it is that it is a 6X6 alpha-numeric matrix in which you can alter to form unique patterns.

This can be used to generate passwords which are hard to crack,
 one can have a printed sequence on a cardboard strip and turn it into an actual key for your digital accounts.

You can use this matrix to encrypt your messages in Ceaser style ,
 i am planning on automating it in the future versions.

use-
    r -> shift the whole matrix right by one place
    l -> shift the whole matrix left by one place
    u -> shift the whole matrix up by one place
    d -> shift the whole matrix down by one place
    help -> display this page
    exit -> exit the application

creating statements-
    x-<num> -> shift a specific row or column
        eg. r-3 (shift the third row to the right),
        u-2 (shift the second column up)

    x:x:x:.... -> execute multiple statements consequently
        eg. r:u (first execute r and then u)
        eg. r-3:u (first execute r-3 and then u)
