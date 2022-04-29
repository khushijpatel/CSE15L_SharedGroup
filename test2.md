# test 1 (same line) --- Works
[link1](some-thing.html) [link2](https://google.com)

# test 2 (an empty line between links) --- Works
[link3](some-thing.html)

[link4](https://google.com)

# test 3 (spaces at link) --- print two spaces
[link5]( some-thing.html )

# test 4 (image inference) --- Logic error: print out an undesired message

![Image](Image inserted here)

[Link6][1]

[1]: (https://google.com)