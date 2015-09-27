#!/usr/bin/env python

old_new_salaries = [
    # (old_salary, new_salary)
    (2401, 2507), (2172, 2883), (2463, 2867), (2462, 3325), (2949, 2974),
    (2713, 3109), (2778, 3771), (2596, 3045), (2819, 2848), (2974, 3322),
    (2539, 2790), (2440, 3051), (2526, 3240), (2869, 3635), (2341, 2495),
    (2197, 2897), (2706, 2782), (2712, 3056), (2666, 2959), (2149, 2377)
]

def is_high_raise(r):
    ???

raises = map(???, old_new_salaries)
high_raises = filter(is_high_raise, raises)
total_high_raises = reduce(lambda a,b: a + b, high_raises)

print "total high raises: %s" % total_high_raises
