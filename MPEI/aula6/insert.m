function [ B ] = insert ( B, k, member_i )
    m = length(B);
    for i = 1: k
        member_i = [member_i num2str(i)];
        h = rem (string2hash(member_i), m) + 1; 
        B(h) = 1;
    end
end