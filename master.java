package com.github.pedrovgs.problem4;

public class SquareRoot {

  private static final double DELTA = 0.1;

 
  public float calculateSquareRootIterative(int number) {
    //Search first candidate
    float candidate = 1f;
    while (candidate * candidate <= number) {
      candidate++;
    }
    candidate--;
    if (isGoodResultForSqrt(number, candidate * candidate)) {
      return candidate;
    }

    //Apply binary search.
    float top = candidate + 1;
    float bottom = candidate;
    float newCandidate = (top + bottom) / 2;
    float result = newCandidate * newCandidate;
    while (!isGoodResultForSqrt(number, result)) {
      if (result > number) {
        top -= 0.1f;
      } else {
        bottom -= 0.1f;
      }
      newCandidate = (top + bottom) / 2;
      result = newCandidate * newCandidate;
    }
    return Math.abs(newCandidate);
  }

 
  public float calculateSquareRootRecursive(int number) {
    return sqrtRecursiveInner(number, 0, number);
  }

  private static float sqrtRecursiveInner(float n, float low, float high) {
    float sqrt = (low + high) / 2;
    float diff = sqrt * sqrt - n;
    if (diff > DELTA) return sqrtRecursiveInner(n, low, sqrt);
    if (-diff > DELTA) return sqrtRecursiveInner(n, sqrt, high);
    return sqrt;
  }

  private static boolean isGoodResultForSqrt(float number, float result) {
    return Math.abs(result - number) < DELTA;
  }
}
