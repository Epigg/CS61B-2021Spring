# CS61B-2021Spring - Data Structure  
Recode what I think should be recoded during learning.  
## Notice  

### Lab2setup  
My Labrary-setup steps:  
- `File`  -> `Project Structure` -> `Project Settings` ->  
  - `Libraryies`: Add file *"javalib"* to *New Project Library* (select **Java**).  
  - `Modules`: Set *Language level* in `Sources` to **Project default**.  

Rather than the offical method in [Lab 2 Setup](https://sp21.datastructur.es/materials/lab/lab2setup/lab2setup).  

### Project 1  
Note that:  
> **LinkedListDeque**  
> - usage of private LinkedList **sentinel**  
> - to define an effective `iterator` method:  
>   - `implements` *java.util.Iterable\<T\>*  
>   - define private class *LinkedDequeIterator* `implements` *java.util.Iterator\<T\>*.  
>   - override the `hasNext` and `next` methods.  
>   - define method `iterator` returns `new LinkedDequeIterator()`.
> - Style: members of a private nested class don't need (and cannot have) the modifier.
> - `equals` method: use `o instanceof Deque` as classchecker and use `.equals()` rather than `!=`.

> **ArrayDeque**
> - implementation(maybe ugly):
>   - use `head` and `tail` to record the index before the front and after the back of the deque.
>   - `resize` method: calculate `firstIndex` and `lastIndex` and `arraycopy` `items` to `newItems` in two ways 
>     according to whether `firstIndex` is larger than `lastIndex`.
>   - other basic methods: `head` and `tail` are the next index to **add** while `firstIndex` and `lastIndex` are the previous index to **remove**.
> - `-1 % items.length` equals `-1` rather than `items.length - 1`.  
  
> **Deque Interface**  
> - the `public` modifier is redundant since Java automatically makes interface methods public.
> - usage of `package`

> **MaxArrayDeque**  
> - The `final` keyword means that the variable cannot be reassigned after its initial value is set.  
> - define a comparator class: `implements` *java.util.Comparator\<T\>* and override the `compare` method.  

> **GuitarHero**  
> - `keyboard.indexOf(key)` returns -1 if no such character `key` occurs in the string `keyboard`.   
> - Enjoy TTFAF!

Test your code actively and use the debugger flexibly!  

## Relevant Links  
- [Skeleton code](https://github.com/Berkeley-CS61B/skeleton-sp21).  
- [Java library](https://github.com/Berkeley-CS61B/library-sp21).  
