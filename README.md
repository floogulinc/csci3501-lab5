# CSci 3501 Lab 5

###### Paul Friederichsen and Waller Li

## Algorithm Explanations

- Our algorithm begin with the first unmatched company and get the mostly preferred programmer who has not been match 
  with the company. If the programmer is not matched with any other company, match the programmer with the company. If 
  the programmer is already matched with another company, identify which of the two companies have a higher preference 
  level to the programmer and match the programmer with the company which they prefers more. The other company get 
  unmatched. Keep getting the company that still remains unmatched and try to match it with the next mostly preferred
  programmer that has not been matched with it until all companies and programmers are matched.
  
- The App class is documented with an example about how to use our match algorithm.
  
#### Why It Always Stops

- We begin to choose a company and match it with its mostly preferred programmer. When the programmer is matched with
  another company that they prefers more, the original company get unmatched. And when a company get unmatched, try to 
  match it with its next mostly preferred programmer. 
  
- Because we loop with unmatched companies and always match a company with the next programmer on its list, all the 
  programmers will at least be matched with a company once. And we will never try to match a company with the same
  programmer twice. Because we match companies and programmers with limited amount of attempts, the algorithm always
  stops.
  
#### Why the Output is Always Satisfactory

- When we try to match a company with a programmer, we always pair it with its mostly preferred programmer. And we 
  match the programmer with a new company when the programmer prefers that company more. Thus, if a programmer is not 
  paired with a company, either the company has a low preference level to that programmer or the programmer prefers 
  another company more than the company. So it is impossible to switch a programmer to another company and improve 
  both of their preferences. Thus, our result is always satisfactory.
  
#### The idea we use to solve the lab problem comes from [Gale–Shapley algorithm (Wikipedia)](https://en.wikipedia.org/wiki/Stable_marriage_problem).
  
## Test Cases Summary

- Our match algorithm is tested with different number of programmer's and company's preferences (N = 0, 1, 2, 3, 5, 10).
  Because the preference sequence it reads will affect how our algorithm can find the satisfactory pairs, we test the 
  match algorithm will random preferences, same company and programmer preferences, and reverse the preference sequence 
  of the company or the programmer at different input sizes.  
  
- By the assertions and the result printed, our algorithm works correctly to produce satisfactory pairs. 
  Our tests and test results are documented in tests folder.
  
