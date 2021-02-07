struct ListNode {
    int val;
    ListNode *next;

    explicit ListNode(int x) : val(x), next(nullptr) {}
};

class Solution {
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
        ListNode *link1 = l1, *link2 = l2;
        int y = 0;
        ListNode *ans = new ListNode(0), *head = ans;
        while (link1 && link2) {
            ans->next = new ListNode((link1->val + link2->val + y) % 10);
            ans = ans->next;
            y = (link1->val + link2->val + y) / 10;
            link1 = link1->next;
            link2 = link2->next;
        }
        while (link1) {
            ans->next = new ListNode((link1->val + y) % 10);
            ans = ans->next;
            y = (link1->val + y) / 10;
            link1 = link1->next;
        }
        while (link2) {
            ans->next = new ListNode((link2->val + y) % 10);
            ans = ans->next;
            y = (link2->val + y) / 10;
            link2 = link2->next;
        }
        if (y != 0) {
            ans->next = new ListNode(y);
        }
        return head->next;
    }
};