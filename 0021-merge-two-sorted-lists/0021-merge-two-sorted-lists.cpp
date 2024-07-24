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
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode* dummy = new ListNode(-1);
        if(!l1 ) return l2;
        if(!l2) return l1;
        ListNode* t1 = l1;
        ListNode* t2 = l2;
        ListNode* tmp = dummy;
        while(t1 != NULL && t2 != NULL){
            if(t1->val < t2->val){
                tmp->next = t1;
                tmp = t1;
                t1 = t1->next;
            }
            else{
                tmp->next = t2;
                tmp = t2;
                t2= t2->next;
            }
        }
        if(t1) tmp->next = t1;
        else tmp->next = t2;
        return dummy->next;
    }
};