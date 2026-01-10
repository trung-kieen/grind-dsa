"""
Must use the separate class LinkList to make sure we have .left and .right property even None
This code just good for itent but not well design
"""
class Solution:
    def list_depths(self, tree_root):
        # Create result list
        rs = [tree_root]

        # Add root to result list

        layer = tree_root
        while layer:
            next_layer = None


            # For each layer iterate over node in previous layer

            while layer is not None:

                # Add child of previous layer to next layer
                if layer.left:
                    # todo refactor to separte function or data structure class
                    if next_layer is None:
                        next_layer = layer.next
                    else:
                        # append to end instead later
                        nex = next_layer.next
                        next_layer.next = layer.left
                        next_layer.next.next = nex

                if layer.right:
                    # todo refactor to separte function or data structure class
                    if next_layer is None:
                        next_layer = layer.next
                    else:
                        # append to end instead later
                        nex = next_layer.next
                        next_layer.next = layer.right
                        next_layer.next.next = nex


                layer = layer.next




            layer = next_layer
            if layer:
                rs.append(layer)

            # If result set is not empty list => append to new


        # Return the result list
        return rs
