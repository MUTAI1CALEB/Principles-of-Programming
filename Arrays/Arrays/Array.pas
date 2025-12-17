program Array_based;
var
    arr: array[0..100] of integer;
    size: integer;

procedure create_arr(var arr: array of integer; size: integer);
var
    i: integer;
begin
    for i:= 0 to size-1 do 
    begin
        writeln('Enter element ', i+1, ': ');
        readln(arr[i]);
        
    end;
end;
procedure add_element(var arr: array of integer; var size: integer);
var
    element: integer;
begin
    writeln('Enter the element to be added:');
    readln(element);
    arr[size] := element;
    size := size + 1;
end;
procedure insert_element(var arr: array of integer; index: integer;var size: integer);
var
    element: integer;
    i: integer;
begin       
    for i:= size-1 downto index do
    begin
        arr[i+1] := arr[i];
    end;
    writeln('Enter the element to be inserted:');
    readln(element);
    arr[index] := element;
    size := size+1;
end;
procedure del_element(var arr: array of integer; var size: integer);
var 
    i: integer;
    element: integer;
    j: integer;
begin
    writeln('Enter the element to be deleted:');
    readln(element);
    for i:=0 to size-1 do
    begin
        if arr[i] = element then
        begin
            for j:=i to size-2 do
            begin
                arr[j] := arr[j+1];
            end;
        end;
    end;
    size := size-1;

end;
procedure find_element(var arr: array of integer;var size: integer);
var
    i: integer;
    element: integer;
    found: boolean;
begin
       writeln('Enter the element to find: ');
       readln(element);

       found := false;
       for i:= 0 to size-1 do
       begin
            if arr[i] = element then
            begin
                writeln('Element found at index: ', i);
                found := true;
            end;
       end;
       if not found then
           writeln('Element not found.');
end;
procedure display(var arr: array of integer; var size: integer);
var
    i: integer;
begin
    for i := 0 to size - 1 do
    begin
        write(' ', arr[i]);
    end;
    writeln;
end;   
{start of the main program}
begin
    writeln('Enter the size of the array: ');
    readln(size);
    create_arr(arr, size);
    add_element(arr, size);
    insert_element(arr, 2, size);
    display(arr, size);
    del_element(arr, size);
    display(arr, size);
    find_element(arr, size);
    display(arr, size);
end.