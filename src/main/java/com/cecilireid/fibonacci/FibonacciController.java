package com.cecilireid.fibonacci;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fibonacci")
public class FibonacciController {
    /**
     * Determine the n-th fibonacci number
     *
     * @param n position of the fibonacci number requested
     * @return the n-th fibonacci number in the sequence
     */
    @GetMapping("findNumber")
    public ResponseEntity<Integer> findFibonacciNumber(@RequestParam int n)
    {
        return ResponseEntity.ok(fibonacci(n));
    }

    /**
     * Recursively find the Fibonacci number at the position in the sequence
     *
     * @param position requested position of fibonacci sequence (i.e. 8th number in sequence)
     * @return fibonacci number at position (i.e. 21)
     */
    private int fibonacci(int position)
    {
        if (position <= 1) {
            return position;
        }
        return fibonacci(position - 1) + fibonacci(position - 2);
    }
}
