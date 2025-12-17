type
    PNode = ^TNode;
    TNode = record
        data: Integer;
        next: PNode;
        end;
procedure create_node(var head: PNode; data: Integer);
var 
    newNode : PNode;
begin
    New(newNode);
    newNode^.data := data;
    newNode^.next := nil;
    head := newNode;
end;
procedure PrintList(head : PNode);
var
    ptr: PNode;
begin
    ptr := head;
    while ptr <> nil do
    begin
        write(ptr^.data, '->');
        ptr := ptr^.next;
    end; 
    writeln('nil');
end;
procedure Add_beg(var head: PNode; value: Integer);
var
    newNode: PNode;
begin
    New(newNode);
    newNode^.data := value;
    newNode^.next := head;
    head := newNode;
end;
procedure Add_end(var head: PNode; value: Integer);
var 
    newNode, ptr : PNode;
begin
    New(newNode);
    newNode^.data := value;
    newNode^.next := nil;
    if head = nil then
    begin
        head := newNode;
        exit
    end;
    ptr := head;
    while ptr^.next <> nil do
    begin
        ptr := ptr^.next;
    end;
    ptr^.next := newNode;
end;
procedure Insert_pos(var head: PNode; position: Integer; value: Integer);
var
    newNode, ptr: PNode;
begin
    new(newNode);
    newNode^.data := value;
    newNode^.next := nil;
    if position = 1 then
    begin
        newNode^.next := head;
        head := newNode;
        exit;
    end;
    ptr := head;
    position := position - 1;
    while position <> 1 do
    begin
        ptr := ptr^.next;
        position := position - 1;
    end;
    newNode^.next := ptr^.next;
    ptr^.next := newNode;
end;
procedure Del_value (var head: PNode; position: Integer);
var 
    ptr, preptr: PNode;
    i: integer;
begin
    ptr := head;
    if position = 1 then
    begin
        head := ptr^.next;
        Dispose(ptr);
    end;
    for i:=1 to position-1 do
    begin
        if ptr = nil then
        begin
            Write('Position out of bounds');
            exit;
        end;
        preptr := ptr;
        ptr := ptr^.next;
    end;
    preptr^.next := ptr^.next;
    Dispose(ptr);
    exit;
end;
procedure Search_element(var head: PNode; value: Integer);
var
    ptr: PNode;
begin
    ptr := head;
    while ptr <> nil do
    begin
        if ptr^.data = value then
        begin
            Write('Element found');
            exit;
        end;
        ptr := ptr^.next;
    end;
    Write('Element not found');
end;
var
    head: PNode;
begin
    head := nil;
    create_node(head, 10);
    Add_beg(head, 20);
    Writeln('After adding 20 at the beginning');
    PrintList(head);
    Add_end(head, 30);
    Writeln('After adding 30 at the end');
    PrintList(head);
    Insert_pos(head, 2, 25);
    Writeln('After inserting 25 at position 2');
    PrintList(head);
    Del_value(head, 3);
    Writeln('After deleting element at position 3');
    PrintList(head);
    Writeln('Searching for element 25....');
    Search_element(head, 25);
end.
