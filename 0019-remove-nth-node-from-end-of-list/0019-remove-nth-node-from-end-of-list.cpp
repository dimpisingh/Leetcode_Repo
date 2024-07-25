/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* dummy = new ListNode(0, head); // Create a dummy node
        ListNode* fast = dummy;
        ListNode* slow = dummy;

        // Move fast ahead by n+1 steps to create a gap of n between slow and
        // fast
        for (int i = 0; i <= n; ++i) {
            fast = fast->next;
        }
        while (fast != NULL) {
            fast = fast->next;
            slow = slow->next;
        }

        // slow->next is the node to remove
        ListNode* nodeToRemove = slow->next;
        slow->next = nodeToRemove->next;

        // Clean up and return the head
        ListNode* newHead = dummy->next;
        delete dummy;        // Free the dummy node
        delete nodeToRemove; // Optionally delete the removed node if managing
                             // memory
        return newHead;
    }
};