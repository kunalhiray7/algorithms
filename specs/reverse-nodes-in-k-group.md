# Reverse Nodes in K-Group

**Change ID:** reverse-nodes-in-k-group
**Status:** Implemented
**Created:** 2026-03-01
**Implemented:** 2026-03-01
**Implemented by:** Claude (/implement command)

---

## Proposal

### Context
This repository is an algorithms training project (Kotlin/JVM) containing LeetCode-style
solutions organized by topic. The `linkedList/` package already contains solutions for
LeetCode 206 (reverse full list), 143 (reorder list), and 19 (remove nth node). LeetCode 25
— reverse nodes in k-group — is the next natural progression in linked-list problem coverage.

### Goals
- A working `reverseKGroup(head: ListNode?, k: Int): ListNode?` function that passes all
  provided examples and edge cases.
- A companion JUnit 5 test class covering at least 6 distinct scenarios.
- Code that follows existing conventions: nullable types, guard clauses, iterative/recursive
  while-loop style, and file-local `ListNode` definition.

### Non-Goals
- Modifying any existing file or shared `ListNode` definition.
- Implementing a generic "reverse sub-list" utility reused across problems.
- Adding Spring Boot endpoints or HTTP-layer code.
- Logging or metrics instrumentation.

### Affected Areas
| Artifact | Action |
|----------|--------|
| `src/main/kotlin/linkedList/ReverseNodesInKGroup25.kt` | **Create** — solution class |
| `src/test/kotlin/linkedList/ReverseNodesInKGroup25Test.kt` | **Create** — JUnit 5 test class |

---

## Requirements

> Normative language: **SHALL** = mandatory. **SHOULD** = recommended. **MAY** = optional.

### Requirement: Reverse k Nodes at a Time

The system SHALL reverse consecutive groups of exactly `k` nodes in the linked list and
return the new head. If fewer than `k` nodes remain at the tail, those nodes SHALL be left
in their original order.

#### Scenario: Even groups — k=2, list length=5

**GIVEN** a linked list `[1, 2, 3, 4, 5]` and `k = 2`
**WHEN** `reverseKGroup(head, 2)` is called
**THEN** the returned list SHALL be `[2, 1, 4, 3, 5]` (node 5 remains unreversed)

#### Scenario: Odd group size — k=3, list length=5

**GIVEN** a linked list `[1, 2, 3, 4, 5]` and `k = 3`
**WHEN** `reverseKGroup(head, 3)` is called
**THEN** the returned list SHALL be `[3, 2, 1, 4, 5]` (nodes 4 and 5 remain unreversed)

#### Scenario: k equals list length

**GIVEN** a linked list `[1, 2, 3]` and `k = 3`
**WHEN** `reverseKGroup(head, 3)` is called
**THEN** the returned list SHALL be `[3, 2, 1]`

#### Scenario: k = 1 (no-op)

**GIVEN** any non-null linked list `[1, 2, 3, 4]` and `k = 1`
**WHEN** `reverseKGroup(head, 1)` is called
**THEN** the returned list SHALL be `[1, 2, 3, 4]` (unchanged)

#### Scenario: List shorter than k

**GIVEN** a linked list `[1, 2]` and `k = 5`
**WHEN** `reverseKGroup(head, 5)` is called
**THEN** the returned list SHALL be `[1, 2]` (unchanged — fewer than k nodes)

#### Scenario: Null head

**GIVEN** a null head pointer and any positive integer `k`
**WHEN** `reverseKGroup(null, k)` is called
**THEN** the function SHALL return `null`

#### Scenario: Single node list

**GIVEN** a linked list `[42]` and `k = 1`
**WHEN** `reverseKGroup(head, 1)` is called
**THEN** the returned list SHALL be `[42]`

### Requirement: No Value Mutation

The implementation SHALL NOT modify the `.val` field of any node. Only `.next` pointers
MAY be reassigned.

---

## Design

### Architecture Overview

The solution follows the **file-per-problem** pattern already established in the `linkedList`
package. Each file is self-contained: it defines a local `ListNode`, the algorithm class,
and a `main()` function for ad-hoc manual testing.

```
linkedList/
├── Node.kt                    (legacy)
├── ListNode (defined per-file in modern solutions)
├── ReverseLinkedList206.kt    (reverse full list — reference)
├── ReorderList143.kt          (reorder list — reference)
├── ReverseNodesInKGroup25.kt  ← NEW
└── ...
```

**Algorithm — Recursive k-group reversal:**

1. Walk forward `k` steps; if fewer than `k` nodes exist, return `head` unchanged.
2. Reverse exactly `k` nodes in-place (three-pointer reversal).
3. The original `head` node (now the tail of the reversed segment) has its `.next` set to
   the result of recursing on the remaining list.
4. Return the new head of the reversed segment.

Recursion depth is O(n/k), which is safe for the LeetCode constraint n ≤ 5000.

### New Components

| Component | Type | Location | Responsibility |
|-----------|------|----------|----------------|
| `ReverseNodesInKGroup25` | Class | `src/main/kotlin/linkedList/ReverseNodesInKGroup25.kt` | Exposes `reverseKGroup()` — single entry point for the algorithm |
| `ListNode` | Data class (local) | Same file | Standard LeetCode node representation used across `linkedList/` solutions |

### Modified Components

_None._ No existing files are changed.

### Data / Interface Contracts

```kotlin
// File-local ListNode — identical pattern to RemoveNthNode.kt and ReverseLinkedList206.kt
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class ReverseNodesInKGroup25 {
    /**
     * LeetCode 25 — Reverse Nodes in k-Group
     * Time:  O(n)  — each node visited and reversed exactly once
     * Space: O(n/k) — recursion stack depth proportional to number of groups
     */
    fun reverseKGroup(head: ListNode?, k: Int): ListNode?
}

// Helper (in test file for assertion convenience)
fun create(array: IntArray): ListNode?      // builds list from array
fun toIntArray(head: ListNode?): IntArray   // flattens list to array for assertion
```

### Design Patterns Applied

| Pattern | Rationale |
|---------|-----------|
| **Recursive decomposition** | Splits the problem into "reverse one group + recurse on rest"; matches the natural substructure of the problem and produces clean code. Preferred over a purely iterative dummy-node approach because the codebase's other reversal problems (206, 143) also use recursive helpers. |
| **Guard clause** | Early `return head` when fewer than k nodes remain — consistent with `if (head?.next == null) return` guard style seen in `ReverseLinkedList206.kt`. |
| **File-local type definition** | `ListNode` is redefined per solution file, matching the established convention in `MergeKSortedLists.kt` and `RemoveNthNode.kt`. |

### Error Handling Strategy

- Kotlin null-safety enforced via `ListNode?` throughout; no explicit null checks beyond
  guard clauses.
- No exceptions are thrown; invalid input (null head, k ≥ list length) results in a safe
  early return.
- Consistent with the existing codebase: no try-catch, no logging framework.

### Dependencies & Constraints

- **No new dependencies.** Uses only `kotlin-stdlib` already on the classpath.
- JVM target: Java 21 (existing project setting — no change required).
- Kotlin 1.9.25 null-safety features (`?.`, `!!`, `?:`) used throughout.

---

## Testing Plan

### Unit Tests

| Test File | What It Tests | Key Scenarios |
|-----------|---------------|---------------|
| `src/test/kotlin/linkedList/ReverseNodesInKGroup25Test.kt` | All scenarios for `reverseKGroup()` | k=2 (partial tail), k=3 (partial tail), k equals length, k=1 no-op, list shorter than k, null input, single node |

### Integration Tests

_Not applicable._ This is a self-contained algorithm with no I/O, network, or persistence
dependencies. Unit tests provide full coverage.

### Test Coverage Targets

- 100% line coverage of `ReverseNodesInKGroup25.kt` (no coverage tooling is configured in
  the project, but manual scenario coverage SHALL cover every branch).
- Minimum 7 `@Test` methods: one per scenario defined in Requirements.

---

## Implementation Tasks

> Ordered by implementation sequence.

- [x] 1. Create `src/main/kotlin/linkedList/ReverseNodesInKGroup25.kt`
  - Add `package linkedList` declaration
  - Define file-local `class ListNode(var \`val\`: Int) { var next: ListNode? = null }`
  - Define `class ReverseNodesInKGroup25` with `fun reverseKGroup(head: ListNode?, k: Int): ListNode?`
  - Implement: (a) walk k steps / guard-return if < k nodes; (b) reverse k nodes; (c) recurse on remainder
  - Add `fun main()` with the two LeetCode examples for manual smoke-test

- [x] 2. Create `src/test/kotlin/linkedList/ReverseNodesInKGroup25Test.kt`
  - Add `package linkedList` declaration
  - Import `org.junit.jupiter.api.Assertions.assertArrayEquals` and `org.junit.jupiter.api.Test`
  - Add private helper `fun create(arr: IntArray): ListNode?` to build a list from an array
  - Add private helper `fun toIntArray(head: ListNode?): IntArray` to flatten list for assertion
  - Write `@Test fun testExample1_k2()` — input `[1,2,3,4,5]` k=2, expected `[2,1,4,3,5]`
  - Write `@Test fun testExample2_k3()` — input `[1,2,3,4,5]` k=3, expected `[3,2,1,4,5]`
  - Write `@Test fun testKEqualsLength()` — input `[1,2,3]` k=3, expected `[3,2,1]`
  - Write `@Test fun testKEqualsOne()` — input `[1,2,3,4]` k=1, expected `[1,2,3,4]`
  - Write `@Test fun testListShorterThanK()` — input `[1,2]` k=5, expected `[1,2]`
  - Write `@Test fun testNullHead()` — input null k=2, expected null
  - Write `@Test fun testSingleNode()` — input `[42]` k=1, expected `[42]`

- [x] 3. Run the full test suite to verify all 7 tests pass
  - Command: `./gradlew test --tests "linkedList.ReverseNodesInKGroup25Test"`

- [x] 4. Run the full project test suite to confirm no regressions
  - Command: `./gradlew test`

---

## Open Questions

- [ ] **ListNode sharing:** Several files redefine `ListNode` locally. If the project ever
  extracts a shared `ListNode` to a common file, this solution will need its local definition
  removed. For now, follow the per-file pattern.
- [ ] **Iterative vs. recursive:** Recursive approach is chosen for clarity and consistency
  with the codebase style. If LeetCode's follow-up ("can you solve in O(1) extra space?") is
  also required, an iterative implementation using a dummy head node and pointer surgery
  should be added as `reverseKGroupIterative()`.

---

## References

- Relevant file: `src/main/kotlin/linkedList/ReverseLinkedList206.kt` (reverse-full-list baseline)
- Relevant file: `src/main/kotlin/linkedList/ReorderList143.kt` (multi-pass linked-list manipulation)
- Relevant file: `src/main/kotlin/linkedList/RemoveNthNode.kt` (canonical `ListNode` definition)
- Relevant file: `src/test/kotlin/linkedList/` (existing test naming and assertion patterns)
- LeetCode problem: https://leetcode.com/problems/reverse-nodes-in-k-group/ (problem 25)
- Codebase Summary: produced by codebase-analyzer sub-agent (Phase 1)
